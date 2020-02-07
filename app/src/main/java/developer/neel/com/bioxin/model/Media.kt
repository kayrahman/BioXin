package developer.neel.com.bioxin.model

import com.google.gson.annotations.SerializedName

data class Media(
    val _links: Links,
    val alt_text: String,
    val author: Int,
    val caption: Caption,
    val comment_status: String,
    val date: String,
    val date_gmt: String,
    val description: Description,
    val guid: Guid,
    val id: Int,
    val link: String,
    val media_details: MediaDetails,
    val media_type: String,
    val meta: List<Any>,
    val mime_type: String,
    val modified: String,
    val modified_gmt: String,
    val ping_status: String,
    val post: Any,
    val slug: String,
    val smush: Smush,
    val source_url: String,
    val status: String,
    val template: String,
    val title: Title,
    val type: String
)


data class Author(
    val embeddable: Boolean,
    val href: String
)

data class Caption(
    val rendered: String
)

data class Description(
    val rendered: String
)


data class MediaDetails(
    val `file`: String,
    val height: Int,
    val image_meta: ImageMeta,
    val sizes: Sizes,
    val width: Int
)

data class ImageMeta(
    val aperture: String,
    val camera: String,
    val caption: String,
    val copyright: String,
    val created_timestamp: String,
    val credit: String,
    val focal_length: String,
    val iso: String,
    val orientation: String,
    val shutter_speed: String,
    val title: String
)

data class Sizes(
    val full: Full,
    @SerializedName("google-ads")  val google_ads: GoogleAds,
    val large: Large,
    val medium: Medium,
    val shop_catalog: ShopCatalog,
    val shop_single: ShopSingle,
    val shop_thumbnail: ShopThumbnail,
    val thumbnail: Thumbnail,
    val woocommerce_gallery_thumbnail: WoocommerceGalleryThumbnail,
    val woocommerce_single: WoocommerceSingle,
    val woocommerce_thumbnail: WoocommerceThumbnail
)

data class Full(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class GoogleAds(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class Large(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class Medium(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class ShopCatalog(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class ShopSingle(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class ShopThumbnail(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class Thumbnail(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class WoocommerceGalleryThumbnail(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class WoocommerceSingle(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val width: Int
)

data class WoocommerceThumbnail(
    val `file`: String,
    val height: Int,
    val mime_type: String,
    val source_url: String,
    val uncropped: String,
    val width: Int
)

data class Smush(
    val sizes: SizesX,
    val stats: Stats
)

data class SizesX(
    @SerializedName("google-ads") val google_ads: GoogleAdsX,
    val large: LargeX,
    val medium: MediumX,
    val shop_catalog: ShopCatalogX,
    val shop_single: ShopSingleX,
    val shop_thumbnail: ShopThumbnailX,
    val thumbnail: ThumbnailX,
    val woocommerce_gallery_thumbnail: WoocommerceGalleryThumbnailX,
    val woocommerce_single: WoocommerceSingleX,
    val woocommerce_thumbnail: WoocommerceThumbnailX
)

data class GoogleAdsX(
    val bytes: Int,
    val percent: Double,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class LargeX(
    val bytes: Int,
    val percent: Double,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class MediumX(
    val bytes: Int,
    val percent: Double,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class ShopCatalogX(
    val bytes: Int,
    val percent: Int,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class ShopSingleX(
    val bytes: Int,
    val percent: Int,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class ShopThumbnailX(
    val bytes: Int,
    val percent: Int,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class ThumbnailX(
    val bytes: Int,
    val percent: Double,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class WoocommerceGalleryThumbnailX(
    val bytes: Int,
    val percent: Double,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class WoocommerceSingleX(
    val bytes: Int,
    val percent: Double,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class WoocommerceThumbnailX(
    val bytes: Int,
    val percent: Double,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)

data class Stats(
    val api_version: String,
    val bytes: Int,
    val keep_exif: Int,
    val lossy: Boolean,
    val percent: Double,
    val size_after: Int,
    val size_before: Int,
    val time: Double
)