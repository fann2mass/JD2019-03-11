<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/users">
        <body>
            <table border="1">
                <tr>
                    <td>game</td>
                    <td>group</td>
                    <td>name</td>
                    <td>standalone</td>
                    <td>description</td>
                    <td>size</td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </body>
    </xsl:template>

    <xsl:template match="/users/user/login"/>
    <xsl:template match="/users/user/password"/>
    <xsl:template match="/users/user/email"/>

    <xsl:template match="/users/user/mods/mod">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/users/user/mods/mod/game">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/mods/mod/group">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/mods/mod/name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/mods/mod/standalone">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/mods/mod/description">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/mods/mod/size">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

  </xsl:stylesheet>