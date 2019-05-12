<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" />

    <xsl:template match="/users">
        <body>
            <table border="1">
                <tr>
                    <td>Trademark</td>
                    <td>Origin country</td>
                    <td>Purchase country</td>
                    <td>Material</td>
                    <td>Width</td>
                    <td>Height</td>
                    <td>Corners</td>
                    <td>In collection since</td>
                    <td>Exchange</td>
                </tr>
                <xsl:apply-templates />
            </table>
        </body>
    </xsl:template>

    <xsl:template match="/users/user/login"/>
    <xsl:template match="/users/user/password"/>
    <xsl:template match="/users/user/email"/>
    <xsl:template match="/users/user/location"/>

    <xsl:template match="/users/user/collection/teaTag">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/trademark">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/originCountry">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/purchaseСountry">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/material">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/width">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/height">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/trademark">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/corners">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/inCollectionSince">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/collection/teaTag/exchange">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>