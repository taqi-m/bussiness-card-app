package com.busines.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.busines.card.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}


@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp)
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IntroSlide(
                name = stringResource(R.string.name),
                title = stringResource(R.string.title)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            InfoBar(
                image = painterResource(R.drawable.baseline_phone_24),
                text = stringResource(R.string.contact_no)
            )
            InfoBar(
                image = painterResource(R.drawable.baseline_share_24),
                text = stringResource(R.string.share)
            )
            InfoBar(
                image = painterResource(R.drawable.baseline_email_24),
                text = stringResource(R.string.email)
            )
        }
    }
}


@Composable
fun InfoBar(
    image: Painter,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = image,
            contentDescription = null
        )
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(start = 16.dp),
            textAlign = TextAlign.Left
        )
    }
}


@Composable
fun IntroSlide(
    modifier: Modifier = Modifier,
    image: Painter = painterResource(R.drawable.android_logo),
    name: String,
    title: String
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .width(128.dp)
    )
    Text(
        text = name,
        style = MaterialTheme.typography.displaySmall,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    )
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
    )
}


fun Color.luminance(): Float {
    return (0.299 * red + 0.587 * green + 0.114 * blue).toFloat()
}


@Preview(
    showSystemUi = true, showBackground = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }

}

@Preview(showBackground = true)
@Composable
fun BottomChipPreview() {
    BusinessCardAppTheme {
        InfoBar(
            painterResource(
                id = R.drawable.baseline_phone_24
            ),
            "Contact no."
        )
    }
}