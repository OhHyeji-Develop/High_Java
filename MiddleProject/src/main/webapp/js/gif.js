/**
 * 
 */
 
 $(".hov-anim").mouseover(function() {
  $(this).attr("src", $(this).data("animated"))
}),
$(".hov-anim").mouseout(function() {
  $(this).attr("src", $(this).data("static"))
});
