/**
 * Created by Jimmie on 12/15/2017.
 */

function aggSearch(input){

    input = input != null ? input : oldVal;
    var latestRequest = url + ":8080/api/mobile/live/search/" + input + "?type=" + searchType + "&page="+page + "&key="+key + "&stripped="+ (resultForm == "stripped" ? true : false);
    $.ajax({
        url: latestRequest,
        type: 'GET',
        dataType: 'json', // added data type
        success: function (res) {
            console.log(latestRequest);
            console.log(input);
            console.log(res);
            showResult(input, res);
            if(latestInput != "") {
                var tmp = latestInput;
                latestInput = "";
                aggSearch(tmp);
            }
            isSearching = false;
            printSearch();

            //$("#resTitle").html("Result from " + input);
            //console.log(JSON.parse(res));
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
function aggPostSearch(input){
    showBusyGif();
    input = input != null ? input : oldVal;
    var data = {
        fields : $('.selectpicker').selectpicker('val'),
        keys: keys,
        value: input,
        type: searchType,
        stripped: (resultForm == "stripped" ? true : false),
        page: page-1,
    };
    $.ajax({
        url: url + ":8080/api/mobile/live/search/?stream="+stream,
        type: 'POST',
        dataType: 'json', // added data type,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        timeout: 5000,
        success: function (res) {
            console.log(data);
            console.log(res);
            showResult(input, res);
            if(latestInput != "") {
                var tmp = latestInput;
                latestInput = "";
                aggPostSearch(tmp);
            }
            isSearching = false;
            hideBusyGif();
            printSearch();
            //$("#resTitle").html("Result from " + input);
            //console.log(JSON.parse(res));
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