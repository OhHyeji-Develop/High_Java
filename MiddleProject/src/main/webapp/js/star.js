
if  ((document.getElementById) && 
window.addEventListener || window.attachEvent){

(function(){

var numberOfStars = 40;

var starSpeed = 2; // 1 to 5 only!

var setTimeOutSpeed = 30;

//End.

var h,y,cy,cx,sy,sx,ref,z,cyx1,cyx2,dpth;
var d = document;
var domWw = (typeof window.innerWidth == "number");
var domSy = (typeof window.pageYOffset == "number");
var pi1 = 180/3.14;
var pi2 = 3.14/180;
var y = [];
var x = [];
var strs = [];
var iniStarSize = [];
var starSize = [];
var distanceFromCentre = [];
var velocity = [];
var direction = [];
var acceleration = [];
var distanceToOuterRim = [];
var posCorrect = [];
var extraZip;
var idx = document.getElementsByTagName('div').length;
var pix = (d.documentElement.style && 
typeof d.documentElement.style.MozOpacity == "string")
?"px":0;
var adj = [0.003,0.006,0.012,0.014,0.016];

for (i = 0; i < numberOfStars; i++){
document.write('<div id="stars'+(idx+i)+'" style="position:absolute;top:0px;left:0px;'
+'width:1px;height:1px;background-color:#ffffff;font-size:1px;"><\/div>');
}

if (domWw) ref = window;
else{ 
 if (d.documentElement && 
  typeof d.documentElement.clientWidth == "number" && 
  d.documentElement.clientWidth != 0)
  ref = d.documentElement;
 else{ 
  if (d.body && 
  typeof d.body.clientWidth == "number")
  ref = d.body;
 }
}

function winSize(){
var mozBar = ((domWw) && ref.innerWidth != d.documentElement.offsetWidth)?20:0;
h = (domWw)?ref.innerHeight:ref.clientHeight; 
w = (domWw)?ref.innerWidth - mozBar:ref.clientWidth;
cy = Math.floor(h/2);
cx = Math.floor(w/2);
cyx1 = 10 * ((h > w)?h:w) / 100;
if (cyx1 < 40) cyx1 = 40;
cyx2 = cyx1 / 2;
dpth = ((h > w)?h:w);
if (dpth < 800) dpth = 800;
extraZip = Math.floor(10 / starSpeed);
}

function rst(s){
sy = (domSy)?ref.pageYOffset:ref.scrollTop;
sx = (domSy)?ref.pageXOffset:ref.scrollLeft;
var cyx = Math.round(Math.random() * 2);
if (cyx == 0){
y[s] = (cy - cyx2) + Math.random() * cyx1;
x[s] = (cx - cyx2) + Math.random() * cyx1;
}
else{
y[s] = h/6 + Math.random() * h/1.5;
x[s] = w/6 + Math.random() * w/1.5;
}
dy = y[s] - cy;
dx = x[s] - cx;
direction[s] = Math.atan2(dy,dx) * pi1;
distanceFromCentre[s] = 0.001 + Math.sqrt(dy*dy + dx*dx);
acceleration[s] = 0;
velocity[s] = (starSpeed * distanceFromCentre[s]) / 100;
distanceToOuterRim[s] = dpth - distanceFromCentre[s];
if (distanceToOuterRim[s] < 1) distanceToOuterRim[s] = 1;
starSize[s] = 1;
posCorrect[s] = 1;
iniStarSize[s] = (z * distanceToOuterRim[i] / 100);
}

function animate(){
for (i = 0; i < numberOfStars; i++){
y[i] += velocity[i] * Math.sin(direction[i] * pi2);
x[i] += velocity[i] * Math.cos(direction[i] * pi2);
acceleration[i] = velocity[i] / (distanceFromCentre[i] + (velocity[i] * extraZip)) * velocity[i];
velocity[i] += acceleration[i];
starSize[i] += iniStarSize[i] + (acceleration[i] / (distanceFromCentre[i] / 4));
posCorrect[i] = starSize[i] / 2;
if (y[i] < 0 + posCorrect[i] || 
x[i] < 0 + posCorrect[i] || 
y[i] > h - posCorrect[i] || 
x[i] > w - posCorrect[i]){
 rst(i);
}
strs[i].top = (y[i] - posCorrect[i]) + sy + pix;
strs[i].left = (x[i] - posCorrect[i]) + sx + pix;
strs[i].height = starSize[i] + pix;
strs[i].width = starSize[i] + pix;
}
setTimeout(animate,setTimeOutSpeed);
}

function init(){
winSize();
starSpeed = parseInt(starSpeed,10);
if (starSpeed > 5) starSpeed = 5;
if (starSpeed < 1) starSpeed = 1;
z = adj[starSpeed - 1];
for (i = 0; i < numberOfStars; i++){
 strs[i] = document.getElementById("stars"+(idx+i)).style;
 rst(i);
}
animate();
}

if (window.addEventListener){
 window.addEventListener("resize",winSize,false);
 window.addEventListener("load",init,false);
}  
else if (window.attachEvent){
 window.attachEvent("onresize",winSize);
 window.attachEvent("onload",init);
} 
})();
}//End.