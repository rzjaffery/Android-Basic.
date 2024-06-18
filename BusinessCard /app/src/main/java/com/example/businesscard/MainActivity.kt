package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    MainPage()

                }
            }
        }
    }
}

@Composable
fun MainPage(){
    Information(
        name = stringResource(R.string.Name),
        title = stringResource(R.string.Designation),
        email = stringResource(R.string.Email),
        social = stringResource(R.string.Social_Handle),
        phone = stringResource(R.string.Phone_number),
        col = Color(0xffccf7ff),
        img = painterResource(R.drawable.lumii_20240412_220152007),
        emailLogo = painterResource(R.drawable.mail_24dp_fill0_wght400_grad0_opsz24),
        socialLogo = painterResource(R.drawable.person_outline_24dp),
        phoneLogo = painterResource(R.drawable.call_24dp_fill0_wght400_grad0_opsz24)
    )
}

@Composable
private fun Information(name:String,title:String,email:String,social:String,phone:String,img: Painter,col: Color,
                        emailLogo: Painter,socialLogo: Painter,phoneLogo: Painter,modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(col),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(painter = img, contentDescription = null,modifier = Modifier.padding(12.dp).clip(shape = MaterialTheme.shapes.small).scale(1.5f).size(200.dp),)

        Text(text = name,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.W400,
            color = Color.Black,
            modifier = Modifier.padding(0.dp)
        )
        Text(text = title,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        emailline(email = email, emailLogo = emailLogo)

        socialline(social = social, socialLogo = socialLogo)

        Phoneline(phone = phone, phoneLogo = phoneLogo)


    }
}

@Composable
fun emailline(email: String, emailLogo: Painter, modifier: Modifier = Modifier) {
    Column {
        Row {
            Image(painter = emailLogo, contentDescription = null,colorFilter = ColorFilter.tint(Color.Black))
            Text(text = email,modifier = Modifier.padding(start = 10.dp),fontSize = 20.sp)

        }
    }
}

@Composable
fun socialline(social:String, socialLogo: Painter, modifier: Modifier = Modifier){
    Column {
        Row {
            Image(painter = socialLogo, contentDescription = null,colorFilter = ColorFilter.tint(Color.Black))
            Text(text = social,modifier = Modifier.padding(start = 70.dp, end = 70.dp),fontSize = 20.sp, textAlign = TextAlign.Center)

        }
    }
}
@Composable
fun Phoneline(phone:String, phoneLogo: Painter, modifier: Modifier = Modifier){
    Column {
        Row {
            Image(painter = phoneLogo, contentDescription = null,colorFilter = ColorFilter.tint(Color.Black))
            Text(text = phone,modifier = Modifier.padding(start = 25.dp, end = 25.dp),fontSize = 20.sp)

        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        MainPage()
    }
}