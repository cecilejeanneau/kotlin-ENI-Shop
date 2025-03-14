package fr.eni.ecole.eni_shop.bo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.squareup.moshi.Json
import fr.eni.ecole.eni_shop.utils.DataRoomConverter
import java.util.Date

@Entity
@TypeConverters(DataRoomConverter::class)
data class Article(
    @PrimaryKey(autoGenerate = true)
    private var _id: Long = 0,
    @Json(name="title")
    private var _title: String = "",
    private var _description: String = "",
    private var _price: Double = 0.0,
    @Json(name="image")
    private var _urlImage: String = "",
    private var _category: String = "",
    @Json(ignore = true)
    private var _date: Date = Date()
){
    var id: Long
        get() = this._id;
        set(value) {
            this._id = value
        }
    var title: String
        get() = this._title;
        set(value) {
            this._title = value
        }
    var description: String
        get() = this._description;
        set(value) {
            this._description = value
        }
    var price: Double
        get() = this._price;
        set(value) {
            this._price = value
        }
    var urlImage: String
        get() = this._urlImage;
        set(value) {
            this._urlImage = value
        }
    var category: String
        get() = this._category;
        set(value) {
            this._category = value
        }
    var date: Date
        get() = this._date;
        set(value) {
            this._date = value
        }

    override fun toString(): String {
        return "Article(title='$title', description='$description', price=$price, urlImage='$urlImage', date=$date)"
    }


}
