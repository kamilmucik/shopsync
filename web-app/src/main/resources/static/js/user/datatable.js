$(document).ready( function () {

 $('#usersTable').DataTable({
            "processing": true,
            "serverSide": true,
            "lengthMenu": [[5,10, 25, 50, -1], [5,10, 25, 50, "All"]],
            "ajax": {
                "url": "/user/list",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    return JSON.stringify(d);
                }
            },
            "columns": [
                {"data": "email",       "width": "20%"},
                {"data": "userName",       "width": "25%"},
                {"data": "userLastname",       "width": "25%"},
                {"data": "role",       "width": "10%"},
                {"data": "enabled",       "width": "5%"},
                {"data": "locked",       "width": "5%"},
               {
                   "data": "id",
                   "width": "10%",
                   "orderable":      false,
                   "render": function (data, type, row) {
                       return "<a href='/user/edit/" + row.idMap + "'>Edytuj</a> | <a style='color: red;'href='/user/delete/" + row.id + "'>Usuń</a>";
                   }
               }
            ],
              "language": languagePL
        });

});