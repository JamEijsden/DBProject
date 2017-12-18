/**
 * Created by Jimmie on 12/15/2017.
 */
var isSearching = false;
var url = "http://35.157.192.42";
var latestInput = "";
var search = "cat";
var keys = ["subscriptionnumber"];
var searchType = "equals";
var resultForm = "stripped"
var oldVal= "";
var oldTrigger;
var page = 1;
var stream = false;





$(document).ready (function(){

    $("small").hide();
    getFieldnames();

    $.fn.exists = function () {
        return this.length !== 0;
    };

    Array.prototype.remove = function() {
        var what, a = arguments, L = a.length, ax;
        while (L && this.length) {
            what = a[--L];
            while ((ax = this.indexOf(what)) !== -1) {
                this.splice(ax, 1);
            }
        }
        return this;
    };

    $(".change-responsive").trigger( "keyup" );

});