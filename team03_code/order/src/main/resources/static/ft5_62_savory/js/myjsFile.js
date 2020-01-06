



$(function () {
    seleAll();
})


function seleAll() {
    $.ajax({
        method: 'get',
        url: '',
        success: function (data) {
            console.log()
            let ds = '';
            $.each(data.data, (i, v) => {
                ds += `
                <li value="${v.foods.id}">
					<div class="menu-img"><img src="${v.foods.photo}" width="55" height="55" /></div>
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
								<i class="price">25</i>
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


function seleTp(xx) {
    $.ajax({
        method: 'get',
        url: '',
        success: function (data) {
            console.log()
            let ds = '';
            $.each(data.data, (i, v) => {
                ds += `
                <li class="active">${v.name}<span class="num-price"></span></li>
                `
            });
            $('#a1').html(ds);
        },
        dataType: 'json'
    })
}





let vm = new Vue({
    el: '#app',
    data: {
        sj:[],
        
    },

})