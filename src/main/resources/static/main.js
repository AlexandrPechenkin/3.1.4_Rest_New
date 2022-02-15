// let userInfo = $('#table')
// let getAllUser = []
//
// getUsers()
//
// function getAllUsers() {
//     fetch("/admin/users", {
//         headers : {
//             'Content-Type': 'application/json',
//             'Accept': 'application/json'
//         }
//
//     }).then((response) => {
//         response.json().then((users) => {
//             users.forEach((user) => {
//                 $("#table").append($('<tr>').append(
//                     $('<td>').append($('<span>')).text(user.id),
//                     $('<td>').append($('<span>')).text(user.firstName),
//                     $('<td>').append($('<span>')).text(user.lastName),
//                     $('<td>').append($('<span>')).text(user.age),
//                     $('<td>').append($('<span>')).text(user.email),
//                     $('<td>').append($('<span>')).text(user.roleUser),
//                     $('<td>').append($('<button>').text('Edit').attr({
//                         "type": "button",
//                         "class": "btn btn-sm btn-info editBtn",
//                         "data-bs-toggle": "modal",
//                         "data-bs-target": "#editModal",
//                     }).data("user", user)),
//                     $('<td>').append($('<button>').text('Delete').attr({
//                         "type": "button",
//                         "class": "btn btn-sm btn-danger deleteBtn",
//                         "data-bs-toggle": "modal",
//                         "data-bs-target": "#deleteModal",
//                     })
//                         .data("user", user))))
//             })
//         })
//     })
// }
//
//
