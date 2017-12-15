/**
 * Created by Jimmie on 12/15/2017.
 */

$("#select-fields").change(function(e){
    $(".change-responsive").trigger( "keyup" );
});

$("input[name='TYPE']").change(function(e){
    searchType = this.value;
    $(".change-responsive").trigger( "keyup" );
});

$("input[name='RESULT']").change(function(e){
    resultForm = this.value;
    $(".change-responsive").trigger( "keyup" );
});

$("input[name='SEARCH']").change(function(e){
    search = this.value;
    if(search == "agg") {
        $("#agg-opt").show();
    } else {
        $("#agg-opt").hide();
    }
});

$("input[name='KEY']").change(function(e){
    if(keys.indexOf(this.value) === -1)
        keys.push(this.value);
    else
        keys.remove(this.value);

    $(".change-responsive").trigger( "keyup" );
});

$(".change-responsive").keyup(function(e){

    var input = e.currentTarget.value;
    var target = e.currentTarget.id;
    if(input == ""){
        latestInput = "";
        $("#keyResult").html("");
        $("#fullResult").html("");
    }

    //  if(oldVal == input) {return;}
    if(isSearching) {
        latestInput = input;
        return;
    }
    oldVal = input;
    isSearching = true;
    oldTrigger = target;
    setTimeout(function(){
            if(search == "cat"){ categoryPostSearch(input); }
            else if (search == "agg"){ aggPostSearch(input); }
        }
        , 200);
});