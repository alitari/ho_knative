<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link href="/css/main.css" rel="stylesheet">
    </head>
    <body>
        <h2>Your message</h2>
        <@spring.bind "greet"/>
        <#if greet??>
            <div>${greet}</div><br>
        </#if>
    </body>
</html>