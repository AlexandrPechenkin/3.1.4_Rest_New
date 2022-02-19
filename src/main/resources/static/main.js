// Отображение списка пользователей в таблице
$(document).ready(getAllUsers());

async function getAllUsers() {
    $('#table').empty();
    await fetch('/api/users', {
        method: 'POST',
    })
        .then((resp) => resp.json())
        .then((data) => {
            console.log(data);
            $.each(data, function (i, user) {
                $("#table").append($('<tr>').append(
                        $('<td>').append($('<span>')).text(user.id),
                        $('<td>').append($('<span>')).text(user.firstName),
                        $('<td>').append($('<span>')).text(user.lastName),
                        $('<td>').append($('<span>')).text(user.age),
                        $('<td>').append($('<span>')).text(user.email),
                        $('<td>').append($('<span>')).text(user.roleUser),
                        $('<td>').append($('<button>').text('Edit').attr({
                            "type": "button",
                            "class": "btn btn-sm btn-info editBtn",
                            "data-bs-toggle": "modal",
                            "data-bs-target": "#editModal",
                        }).data("user", user)),
                        $('<td>').append($('<button>').text('Delete').attr({
                            "type": "button",
                            "class": "btn btn-sm btn-danger deleteBtn",
                            "data-bs-toggle": "modal",
                            "data-bs-target": "#deleteModal",
                        })
                            .data("user", user))
                    )
                );

            })
        })
}

// Добавление нового юзера
$('.userAdd').on('click', async function () {

    $('#userTable').trigger('click');

    await fetch('/api/add', {
        method: 'POST',
        body: new FormData($(".formAddUser")[0]),
    })
        .then(() => {
            getAllUsers();
            $('.formAddUser')[0].reset()
        })
});

// Селектор с ролями
fetch('/api/roles', {
    method: 'POST',
})
    .then((resp) => resp.json())
    .then((data) => {
        $.each(data, function (i, role) {
            $('.roles').append($('<option>').text(role.name).attr({
                    "value": role.id,
                })
            )
        })
    })

// Модальное окно обновления
$(document).on("click", ".editBtn", function () {
    let user = $(this).data('user');
    $('#idEdit').val(user.id);
    $('#firstNameEdit').val(user.firstName);
    $('#lastNameEdit').val(user.lastName);
    $('#ageEdit').val(user.age);
    $('#emailEdit').val(user.email);

    $(document).on("click", ".editUser", async function () {
        await fetch('/api/edit', {
            method: 'POST',
            body: new FormData($(".formEditUser")[0]),
        })
            .then(() => {
                $('.hideModal').trigger('click');
                $('.formEditUser')[0].reset();
                getAllUsers();
            })
    });
})

//Модальное окно удаления пользователя
$(document).on("click", ".deleteBtn", function () {
    let user = $(this).data('user');
    $('#idDelete').val(user.id);
    $('#firstNameDelete').val(user.firstName);
    $('#lastNameDelete').val(user.lastName);
    $('#ageDelete').val(user.age);
    $('#emailDelete').val(user.email);

    let formData = new FormData()
    formData.append('id', user.id)


    $(document).on("click", ".deleteUser", async function () {
        await fetch('/api/delete', {
            method: 'POST',
            body: formData,
        })
            .then(() => {
                $('.hideModal2').trigger('click');
                getAllUsers();
            })
    });
})
