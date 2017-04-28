window.onload = function(){
	$('nav .logo').on('click', function(){
		window.location.href = "Gwy_home.html";
	})
	var data = {
		data: $('input').val()
	};
	$('.searchbtn').on('click', function(){
		$.ajax({
			url:      '/path/to/file',
			type:     'post',
			dataType: 'json',
			data:     data,
			success:  function(result){
				showMerchandise(result);
			},
			error:    function(result) {
				alert('服务器繁忙，请稍后重试！');
			}
		})
	})
	var images = [];
	for(var i=1;i<20;i++){
		images.push(i+'.jpg');
	}
	//点击“加载更多”之后，再显示12个图片
	$('#content .more').on('click',function(){
		// var pros = [];
		// for(var i=20;i>8;i--){
		// 	pros.push('<img src="../resources/Images/flowers/'+i+'.jpg" alt="图片无法显示">\
		// 						<p class="description">2017夏季新款女装 气质长裙 这个可能适合我</p>\
		// 						<p class="price">￥168.00</p>')
		// }
		// console.log(pros);
		// Vue.component('todo-item',{
		// 	props: ['todo'],
		// 	template: '<div class="pro">\
		// 	{{ pro }}\
		// 	</div>'
		// })
		// var vm = new Vue({
		// 	el: "#imgBox",
		// 	data: {
		// 		pros: pros
		// 	}
		// })
		for(var i=20;i>8;i--){
			var parent = document.getElementsByClassName('tab-pane active')[0];
			var box = document.createElement('div');
			box.className = "pro";
			parent.appendChild(box);
			var img = document.createElement('img');
			var folder = parent.id;
			img.src = "../resources/Images/"+folder+"/"+i+".jpg";
			box.appendChild(img);
			var p1 = document.createElement('p');
			p1.className = "description add";
			box.appendChild(p1);
			$("p.description.add").html("夏季时尚气质雪纺衬衫 我可以试试");
			var p2 = document.createElement('p');
			p2.className = "price add";
			box.appendChild(p2);
			$('p.price.add').text('￥59.99');
		}
	})
}
function showMerchandise(src) {
	
}