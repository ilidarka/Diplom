<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">


<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<#if isAdmin>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new job
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="jobName" placeholder="Название работы" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control input--big" name="text" placeholder="Введите описание" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="tag" placeholder="Тэг">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>
</#if>

<div class="card-columns">
    <#list jobs as job>
    <div class="card my-3">
        <div class="m-2 win--head">
            <span>${job.text}</span>

        </div>
        <div class="card-footer text-muted">
            Job name: ${job.jobName} <br>
            Author: ${job.authorName} <br>
            Tag: <i>${job.tag}</i> <br>
            <a href="/main/getJobById/${job.id}">Accept job</a>
            <#if isAdmin>
                <a href="/main/deleteJob/${job.id}">Delete</a>
            </#if>
        </div>
    </div>
    <#else>
    No jobs
    </#list>
</div>

</@c.page>
