$(document).ready( function () {

 $('#productTable').DataTable({
            "processing": true,
            "destroy": true,
            "serverSide": true,
            "lengthMenu": [[8,16, 32, 64], [8,16, 32, 64]],
            "ajax": {
                "url": "/product/list",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    return JSON.stringify(d);
                }
            },
            "columns": [
                {"data": "name", "title": "Nazwa", "width": "30%"},
            ],
          "initComplete": function(settings, json) {
            // show new container for data
            $('#new-list').insertBefore('#productTable');
            $('#new-list').show();
          },
          "rowCallback": function( row, data ) {

            $('#new-row').prepend('<div class="column"><h2> ' + data.name + '</h2><img src="'+data.mainImg+'" /><p>'+data.amount+'</p><p>'+data.description+'</p></div>');

          },
          "preDrawCallback": function( settings ) {
            // clear list before draw
            $('#new-row').empty();
          },
          "language": languagePL
        });

});