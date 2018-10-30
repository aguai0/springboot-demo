function moveUp(obj) {
    var current = $(obj).parent().parent();
    var prev = current.prev();
    if (current.index() > 0) {
        current.insertBefore(prev);
        current_order = current.children(".ordertd").html();
        prev_order = prev.children(".ordertd").html();
        current.children(".ordertd").html(prev_order);
        prev.children(".ordertd").html(current_order);
    }
}

function moveDown(obj) {
    var current = $(obj).parent().parent();
    var next = current.next();
    if (next) {
        current.insertAfter(next);
        current_order = current.children(".ordertd").html();
        next_order = next.children(".ordertd").html();
        current.children(".ordertd").html(next_order);
        next.children(".ordertd").html(current_order);
    }
}

function removeTr(obj) {
    var current = $(obj).parent().parent();
    var nextall = current.nextAll();
    current.remove();
    current_order = current.children(".ordertd").html();
    $.each(nextall, function () {
        $(this).children(".ordertd").html(current_order++);
    });
}

function addTr0() {
    var datatr_counts = $(".datatbody").children("tr.datatr").length;
    datatr_counts++;
    //alert(datatr_counts);
    var addtrhtml = '<tr class="datatr">\n' +
        '    <td class="ordertd">' + datatr_counts + '</td> \n' +
        '\t<td></td>  \n' +
        '    <td><input type="text" name="textfield" class="editText" id="textfield"></td>  \n' +
        '    <td> </td>  \n' +
        '    <td><input type="text" name="textfield5" id="textfield5"></td>  \n' +
        '    <td><input type="checkbox" name="checkbox" id="checkbox"></td>  \n' +
        '    <td><input type="checkbox" name="checkbox5" id="checkbox5"></td>  \n' +
        '    <td><a href="javascript:void(0)" onClick="moveUp(this)">上移</a>&nbsp;<a href="javascript:void(0)" onClick="moveDown(this)">下移</a>&nbsp;<a href="javascript:void(0)" onClick="removeTr(this)">删除</a></td>  \n' +
        '  </tr> ';
    $(".datatbody").append(addtrhtml);
}

function addTr() {
    var datatr_counts = $(".datatbody").children("tr.datatr").length;
    datatr_counts++;
    var addtrhtml =
        '                     <tr class="datatr">\n' +
        '                        <td class="ordertd">' + datatr_counts + '</td>\n' +
        '                        <td width="18%">\n' +
        '                            <div class="table-form-item">\n' +
        '                                <label class="table-label">名称</label>\n' +
        '                                <div class="table-input" style="width: 150px">\n' +
        '                                    <input type="text" name="colName" lay-verify="required" lay-vertype="tips" autocomplete="off" class="layui-input">\n' +
        '                                </div>\n' +
        '                            </div>\n' +
        '                        </td>\n' +
        '                        <td width="18%">\n' +
        '                            <div class="table-form-item">\n' +
        '                                <label class="table-label">类型</label>\n' +
        '                                <div class="table-input" style="width: 150px">\n' +
        '                                    <input type="text" name="colType" lay-verify="required" lay-vertype="tips" autocomplete="off" class="layui-input">\n' +
        '                                </div>\n' +
        '                            </div>\n' +
        '                        </td>\n' +
        '                        <td width="18%">\n' +
        '                            <div class="table-form-item">\n' +
        '                                <label class="table-label">字段</label>\n' +
        '                                <div class="table-input" style="width: 150px">\n' +
        '                                    <input type="text" name="fieldName" lay-verify="required" lay-vertype="tips" autocomplete="off" class="layui-input">\n' +
        '                                </div>\n' +
        '                            </div>\n' +
        '                        </td>\n' +
        '                        <td width="31%">\n' +
        '                            <div class="table-form-item">\n' +
        '                                <label class="table-label">函数</label>\n' +
        '                                <div class="table-input" style="width: 240px">\n' +
        '                                    <input type="text" name="function" lay-verify="required" lay-vertype="tips" autocomplete="off" class="layui-input">\n' +
        '                                </div>\n' +
        '                            </div>\n' +
        '                        </td>\n' +
        '                        <td width="15%">\n' +
        '                            <a href="javascript:void(0)" type="button" class="layui-btn layui-btn-xs" onClick="moveUp(this)"><i class="layui-icon"></i>上移</a>\n' +
        '                            <a href="javascript:void(0)" type="button" class="layui-btn layui-btn-xs" onClick="moveDown(this)"><i class="layui-icon"></i>下移</a>\n' +
        '                            <a href="javascript:void(0)" type="button" class="layui-btn layui-btn-xs" onClick="removeTr(this)"><i class="layui-icon"></i>删除</a>\n' +
        '                        </td>\n' +
        '                    </tr>';
    $(".datatbody").append(addtrhtml);
}