
$(function () {
    alter("seleAll");
    seleAll();
})


function seleAll() {
    alter("111");
    $.ajax({
        method: 'get',
        url: '../buyerlist/show/list',
        success: function (data) {
            let ds = '';
            $.each(data.data, (i, v) => {
                ds += `
                <li>
					<div class="menu-img"><img src=`${v.foods.photo}` width="55" height="55" /></div>
						<div class="menu-txt">
							<h4>${v.foods.name}</h4>
							<p class="list1">${v.foods.info}</p>
							<p class="list2">
							<b>￥${v.foods.price}</b>
							<div class="btn">
								<button class="minus">
								<strong></strong>
								</button>
								<i>0</i>
								<button class="add">
								<strong></strong>
								</button>
								<i class="price">${v.foods.price}</i>
								</div>
								</p>
					</div>
				</li>
                `
            });
            $('#a1').html(ds);
        },
        dataType: 'json'
    })
}


// let vm = new Vue({
//     el: '#app',
//     data: {
//
//     },
//
// })
