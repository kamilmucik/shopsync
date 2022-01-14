/* Formatting function for row details - modify as you need */
function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>Changelog:</td>'+
            '<td>'+d.description+'</td>'+
        '</tr>'+
    '</table>';
}
$(document).ready( function () {



var table = $('#platformVersionsTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/versions/list",
            "type": "POST",
            "dataType": "json",
            "contentType": "application/json",
            "data": function (d) {
                d.platformCode = $('#myInput').val();
                return JSON.stringify(d);
            }
        },
        "columns": [
            {"data": "number",       "width": "10%"},
            {"data": "enviroment",     "width": "10%"},
            {"data": "date",     "width": "20%"},
            {"data": "installer",     "width": "10%"},
            {
                "className":      'details-control',
                "orderable":      false,
                "width": "5%",
                "data":           null,
                "defaultContent": ''
            },
            {
                "data": "id",
                "width": "15%",
                "orderable":      false,
                "render": function (data, type, row) {
                    return "<a href='/platform/edit/"+$('#myInput').val()+"/" + row.id + "'>Edytuj</a> | <a style='color: red;'href='/platform/delete/"+$('#myInput').val()+"/" + row.id + "'>Usuń</a>";
                }
            }
        ],
         "language": languagePL
    });


    // Add event listener for opening and closing details
    $('#platformVersionsTable tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );

        if ( row.child.isShown() ) {
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );



});