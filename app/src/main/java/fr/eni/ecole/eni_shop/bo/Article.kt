package fr.eni.ecole.eni_shop.bo

import java.util.Date

data class Article(
    private var _id: Long = 0,
//    var _name: String,
    private var _title: String = "",
    private var _description: String = "",
    private var _price: Double = 0.0,
    private var _urlImage: String = "",
    private var _category: String = "",
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
