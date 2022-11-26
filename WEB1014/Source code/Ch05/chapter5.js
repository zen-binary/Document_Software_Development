/*function Dog(dogName, weight, color, breed, type) { 
	this.dogName = dogName; 
	this.weight = weight; 
	this.color = color; 
	this.breed = breed; 
	this.type = type; 
	this.sua = function () {
		return "Gau Gau";
	};
} 
Dog[0] = new Dog("Jacky", 0.8, "brown", "chihuahua teacup", "short hair" );
Dog[1] = new Dog("Javascript", 1, "brown", "chihuahua mini", "long hair" );
Dog[2] = new Dog("Jscript", 1, "white", "chihuahua", "long hair" );
Dog[3] = new Dog("Jscript", 1, "black & white", "chihuahua", "short hair" );
Dog[1].dogName;
for (var x in Dog) {
    console.log(Dog[x].dogName);
}

console.dir(window.history);
console.dir(history);
window.history.go(-1);//go back to previous page
console.dir(window.navigator);*/

let dog = { 
    dogName: "JavaScript", 
    weight: 2.4, 
    color: "brown", 
    breed: "chihuahua",  
    burglarBiter: true 
};
console.log(dog);
dog.age=3;
console.log(dog);

if (typeof document.body.firstElementChild != "undefined") {
	alert("Browser ho tro phuong thuc firstElementChild");
} else {
	alert("Browser khong ho tro phuong thuc firstElementChild");
}



