/**
 * Created by Jimmie on 12/15/2017.
 */

function printSearch(){
    var s = "";
    s += search == "cat" ? "category " : "raw data ";
    s += "- " + searchType + " ";
    $("#query").html(s);
}

function changePage(opt){
    if(opt == -1 && page == 0){
        console.log("wat");
        return;
    }
    if(opt == -1) {
        page--;
    } else {
        page++;
    }
    console.log("wat?")
    $(".change-responsive").trigger( "keyup" );
}

function populateSelectableFields(fields) {
    $.each(fields, function(i, field){
        $("#select-fields").append(
            '<option id="field' + i + '">' +
            field +
            '</option>');
    });
    $("#select-fields").selectpicker('refresh');
}

function clearField(e){
    console.log(e);
    $("#keyResult").html("");
    $("#fullResult").html("");
    oldTrigger= null;
    oldVal = "";
    e.val("");
}

function showResult(keyword, result){
    var resultDiv = $("#keyResult");
    var contentDiv = $("#fullResult");
    resultDiv.html("");
    contentDiv.html("");

    var re = new RegExp(keyword, 'g');
    $.each(result, function(k, v){
        resultDiv.append(
            '<div>'+
            '<button type="button" class="btn btn-outline-info select-button" style="width: 100%;" data-toggle="collapse" id="'+k+'" data-target="#res'+k+'">' +
            v["customeridentificationnumber"] + ":" + v["msisdn"] +
            '</button>' +
            '</div><br>'
        );
        contentDiv.append(

            '<div id="res'+k+'" class="collapse">' +
            '<pre>' +
            JSON.stringify(v ,null,2).replace(re, '<span style="color:#5bc0de;">' + keyword + '</span>') +
            '</pre>'+
            '</div>'+ '<br>'
        );
    });

    $(".select-button").click( function() {
        $(this).hasClass("btn-outline-info") ? $(this).toggleClass('btn-info btn-outline-info') : $(this).toggleClass('btn-outline-info btn-info');
    });
}