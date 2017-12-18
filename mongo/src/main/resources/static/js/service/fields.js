/**
 * Created by Jimmie on 12/15/2017.
 */
function getFieldnames(){
    $.ajax({
        url: url + ":8080/api/fields",
        type: 'GET',
        dataType: 'json', // added data type
        success: function (res) {
            console.log(res);
            populateSelectableFields(res);
        },
        error: function (err){
            isSearching = false;
            $("#warn-alert").fadeTo(2000, 500).slideUp(500, function(){
                $("#warn-alert ").slideUp(500);
            });
            //console.log(JSON.parse(err));
        }
    });
}