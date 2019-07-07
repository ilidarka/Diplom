<#import "parts/common.ftl" as c>

<@c.page>
List of users

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td class="cell--table"><a href="cabinet/${user.username}">${user.username}</a></td>
            <td class="cell--table"><#list user.roles as role>${role}<#sep>, </#list></td>
            <td class="cell--table"><a class="btn--table" href="/user/${user.id}">edit</a></td>
            <td class="cell--table"><a class="btn--table" href="/user/deleteUser/${user.id}">delete</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>
