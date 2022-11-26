/*function doingStuff() {
    if (true) {
      var x = "local";
    }
    console.log(x);
}
doingStuff();*/
//result: local

/*function doingStuff() {
    if (true) {
      let x = "local";
    }
    console.log(x);
}
doingStuff();*/
//result: ReferenceError: x is not defined

/*let globalVar = "Accessible everywhere!";
console.log("Outside function:", globalVar);
function creatingNewScope(x) {
  console.log("Access to global vars inside function." , globalVar);
}
creatingNewScope("some parameter");
console.log("Still available:", globalVar);*/
//Outside function: Accessible everywhere!
//Access to global vars inside function. Accessible everywhere!
//Still available: Accessible everywhere!

/*for (let i = 0; i < 10; i++) {
  console.log(i);
  if (i === 4) {
    break;
  }
}

let i = 1;
while (i < 50) {
  if (i % 2 === 0){
    continue;
  }
  console.log(i);
  i++;
}*/
for (let i = 0; i < 10; i++) {
  console.log(i);
  if (i === 4) {
     break;
  }
}








