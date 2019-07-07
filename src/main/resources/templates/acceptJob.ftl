<#import "parts/common.ftl" as c>



<@c.page>

    <span class="cab--name">Имя: </span>${job.jobName}<br>

    <span class="cab--name">Описание работы: </span><br>

    <div class="label--big">${job.text} <br></div>

    <span class="cab--name">Tag: </span>${job.tag}<br>

    <form method="post" enctype="multipart/form-data" action="/main/upload">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>


</@c.page>
