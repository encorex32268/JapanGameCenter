package com.lihan.japangamecenter.presentation.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.japangamecenter.R
import com.lihan.japangamecenter.data.map.model.GameCenter
import com.lihan.japangamecenter.ui.LocalSpacing

@Preview
@Composable
fun StoreCard(
    modifier: Modifier = Modifier,
    gameCenter: GameCenter = GameCenter(
        name = "タイトーステーション 札幌狸小路2丁目店",
        address = "北海道札幌市中央区南三条西2-14",
        lat = 43.058197,
        lng = 141.3386314,
        maker = "TAITO"
    )
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.spaceSmall),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = gameCenter.maker,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .padding(10.dp)

            )

            Spacer(modifier = Modifier.width(spacing.default))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = gameCenter.name,
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                Text(
                    text = gameCenter.address,
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp
                )
            }






        }

    }

}