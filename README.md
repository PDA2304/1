# Retrofit
'com.squareup.retrofit2:retrofit:(insert latest version)'
# Picasso
'com.squareup.picasso:picasso:(insert latest version)'
# id
id 'kotlin-android-extensions'
# Converter
'com.squareup.retrofit2:converter-gson:2.9.0'


# Interfase
interface Api {

    @FormUrlEncoded
    @POST("register")
    fun registration(
        @Field("firstname") firstname: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegistrationModel>


    @FormUrlEncoded
    @POST("resetPassword")
    fun resetPassword(@Field("email") email: String): Call<Object>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginModel>


    @GET("places")
    fun places(): Call<ArrayList<PlacesModel>>

    @GET("categorys/{placeId}")
    fun categorys_placeId(@Path("placeId") placeId: String): Call<ArrayList<HashMap<String, String>>>

    @GET("products/{placeId}")
    fun products_placeId(@Path("placeId") placeId: Int): Call<ArrayList<ModelProducts>>


    @GET("products/{placeId}/{categoryId}x")
    fun products_placeId_categoryId(@Path("placeId") placeId : Int , @Path("categoryId") categoryId : Int) : Call<ArrayList<ModelProducts>>
}


#Response
var retrofit = Retrofit.Builder().baseUrl("https://eda.ucmpt.ru/api/")
                .addConverterFactory(GsonConverterFactory.create()).build()

            retrofit.create(Api::class.java).login(
                binding.TextInputEditTextEmail.text.toString(),
                binding.TextInputEditTextPassword.text.toString()
            ).enqueue(object : Callback<LoginModel> {
                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                    if (response.body()!!.data.isEmpty()) {
                        binding.TextInputLayoutPasswrod.isEnabled = true
                        binding.TextInputLayoutPasswrod.error = response.body()!!.error["email"]
                        binding.TextInputLayoutEmail.isEnabled = true
                        binding.TextInputLayoutEmail.error =
                            response.body()!!.error["password"]
                    } else {
                        var intent = Intent(this@SignIn, MainActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                        intent.putExtra("data", response.body()!!.data)
                        Toast.makeText(this@SignIn, response.body()!!.data, Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                }
            })
