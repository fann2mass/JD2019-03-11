<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

<xsl:template match="/clients">
    <meta charset="utf-8"/>
    <body>
    <table border="1">
        <tr>
            <td>Description</td>
            <td>Firm</td>
            <td>Price</td>
            <td>Size</td>
            <td>Color</td>
        </tr>
        <xsl:apply-templates/>
    </table>
    </body>
</xsl:template>

    <xsl:template match="/clients/client">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/clients/client/buys">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/clients/client/buys/buy">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/clients/client/buys/buy/description">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/buys/buy/firm">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/buys/buy/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/buys/buy/size">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/buys/buy/color">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>
