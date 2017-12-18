/**
 * Created by Jimmie on 12/15/2017.
 */
function categorySearch(input){
    var latestRequest = url + ":8080/api/mobile/search/" + input + "?type=" + searchType + "&page="+page + "&stripped="+ (resultForm == "stripped" ? true : false);
    input = input != null ? input : oldVal;
    $.ajax({
        url: latestRequest,
        type: 'GET',
        dataType: 'json', // added data type
        success: function (res) {
            console.log(latestRequest);
            console.log(input);
            console.log(res);
            $("#pages").html(page);
            showResult(input, res);
            if(latestInput != "") {
                var tmp = latestInput;
                latestInput = "";
                categorySearch(tmp);
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

function categoryPostSearch(input){
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
        url: url + ":8080/api/mobile/search/",
        type: 'POST',
        dataType: 'json', // added data type,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        timeout: 5000,
        success: function (res) {
            console.log(data);
            console.log(res);
            $("#pages").html(page);
            showResult(input, res);
            if(latestInput != "") {
                var tmp = latestInput;
                latestInput = "";
                aggPostSearch(tmp);
            }
            isSearching = false;
            printSearch();
            hideBusyGif();
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