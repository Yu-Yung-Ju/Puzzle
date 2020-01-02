/*
 * p.70 
 * 
 */


$(document).ready(function() {
	let getRandom = function(num) {
		let my_num = Math.floor(Math.random()*num);
		return my_num;
	}

	let hideCode = function(){
		let numRand = getRandom(4);
		numRand = 0;
		$(".guess_box").each(function(index, item){
			if(numRand === index){
				$(this).append("<span id ='has_discount'></span>");
				return false; //false를 리턴하여 함수를 종료
			}
		}); //hideCode를 호출했을때 반복
	}
	
	hideCode();
	
	let checkForCode = function(){
		let discount ="";
		if($.contains(this, document.getElementById("has_discount"))) {
			let my_num = getRandom(100);
			discount = "<p>Your Code : "+new Date().getTime()+my_num+"%</p>";
		} else {
			discount = "<p>Sorry, no Discount this time! </p>";
		}
		$(this).append(discount);
		$(".guess_box").each(function(){
			if($.contains(this, document.getElementById("has_discount"))){
				$(this).addClass("discount");
			}else{
				$(this).addClass("no_discount");
			}
			$(this).unbind("click");
		});
	}
	
	
	
	$(".guess_box").click(checkForCode);
});
