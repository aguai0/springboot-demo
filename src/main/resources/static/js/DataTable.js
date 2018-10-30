
// setInterval(function(){
    $.get(CAR_PATH + '/DataTable/get.do_',
        {
            "page": 'order',
            "table": '1001'
        }).done(function (data) {
        $('#table1').DataTable(data)
    });
// }, 10000)

function getData(){
    $.get(CAR_PATH + '/DataTable/get.do_',
        {
            "page": 'order',
            "table": '1002'
        }).done(function (data) {
        data.retrieve = true
        $('#table2').DataTable(data)
    });
}

getData();

setInterval(function(){
    getData();
}, 10000)





