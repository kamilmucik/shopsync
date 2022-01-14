$(document).ready( function () {

 $('#usersTable').DataTable({
            "processing": true,
            "serverSide": true,
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
                {"data": "email",       "width": "80%"},
               {
                   "data": "id",
                   "width": "20%",
                   "orderable":      false,
                   "render": function (data, type, row) {
                       return "<a href='/user/edit/" + row.id + "'>Edytuj</a> | <a style='color: red;'href='/user/delete/" + row.id + "'>Usuń</a>";
                   }
               }
            ],
              "language": languagePL
        });

});