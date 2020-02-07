package developer.neel.com.bioxin.model

import com.google.gson.annotations.SerializedName

data class Post(
    val _links: Links,
    val brands: List<Brand>,
    val comment_status: String,
    val content: Content,
    val date: String,
    val date_gmt: String,
    val excerpt: Excerpt,
    val featured_media: Int,
    val guid: Guid,
    val id: Int,
    val link: String,
    val meta: List<Any>,
    val modified: String,
    val modified_gmt: String,
    val ping_status: String,
    val slug: String,
    val status: String,
    val template: String,
    val title: Title,
    val type: String
)

data class Links(
    val about: List<About>,
    val collection: List<Collection>,
    val curies: List<Cury>,
    val replies: List<Reply>,
    val self: List<Self>,
    @SerializedName("wp:attachment")  val attachment: List<WpAttachment>,
    @SerializedName("wp:featuremedia") val featuredmedia: List<WpFeaturedmedia>
)

data class About(
    val href: String
)

data class Collection(
    val href: String
)

data class Cury(
    val href: String,
    val name: String,
    val templated: Boolean
)

data class Reply(
    val embeddable: Boolean,
    val href: String
)

data class Self(
    val href: String
)

data class WpAttachment(
    val href: String
)

data class WpFeaturedmedia(
    val embeddable: Boolean,
    val href: String
)

data class Brand(
    val id: Int,
    val name: String,
    val slug: String
)

data class Content(
    val `protected`: Boolean,
    val rendered: String
)

data class Excerpt(
    val `protected`: Boolean,
    val rendered: String
)

data class Guid(
    val rendered: String
)

data class Title(
    val rendered: String
)