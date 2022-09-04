$(document).ready( function () {

 $('#eventLogTable').DataTable({
            "processing": true,
            "destroy": true,
            "serverSide": true,
            "lengthMenu": [[5,10, 25, 50], [5,10, 25, 50]],
            "ajax": {
                "url": "/eventlog/list",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    return JSON.stringify(d);
                }
            },
            "columns": [
                {"data": "lastupdate",       "width": "10%"},
                {"data": "type",       "width": "5%"},
                {"data": "log",       "width": "70%"},
            ],
              "language": languagePL
        });

});