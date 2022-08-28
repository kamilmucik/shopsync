$(document).ready( function () {

 $('#shopTable').DataTable({
            "processing": true,
                        "destroy": true,
            "serverSide": true,
            "lengthMenu": [[5,10, 25, 50, -1], [5,10, 25, 50, "All"]],
            "ajax": {
                "url": "/shop/list",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    return JSON.stringify(d);
                }
            },
            "columns": [
                {"data": "name",       "width": "30%"},
               {
                   "data": "id",
                   "width": "10%",
                   "orderable":      false,
                   "render": function (data, type, row) {
                       return "<a href='/shop/edit/" + row.id + "'>Edytuj</a>";
                   }
               }
            ],
              "language": languagePL
        });

});