<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
>
    <xsl:output method="html"/>

    <xsl:template match="/site">
        <body>
            <table>
                <tr>
                    <td>Description</td>
                    <td>Content</td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </body>
    </xsl:template>

    <xsl:template match="/site/catalogs">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/site/catalogs/catalog">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/site/catalogs/catalog/elements">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/site/catalogs/catalog/elements/element">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/site/catalogs/catalog/name">
        <tr>
            <td>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="/site/catalogs/catalog/elements/element/description">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/site/catalogs/catalog/elements/element/content">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/site/aboutus">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/site/aboutus/about">
        <tr>
            <td>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="/site/shortinfo">
        <tr>
            <td>City</td>
            <td>Address</td>
            <td>Notation</td>
            <td>Managers numbers</td>
        </tr>
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/site/shortinfo/city">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/site/shortinfo/address">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/site/shortinfo/notation">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/site/shortinfo/managerstel">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>


    <xsl:template match="/site/properties">
        <tr>
            <td>Property</td>
            <td>Info</td>
        </tr>
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/site/properties/property">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/site/properties/property/mark">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/site/properties/property/info">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

</xsl:stylesheet>