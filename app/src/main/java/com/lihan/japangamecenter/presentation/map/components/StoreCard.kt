package com.lihan.japangamecenter.presentation.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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

@Composable
fun StoreCard(
    modifier: Modifier = Modifier,
    store : GameCenter,
    OnCloseClick:() -> Unit,
    OnItemClick:(GameCenter) -> Unit
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .height(100.dp)
            .background(Color.White)
    ){
        Icon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(spacing.spaceSmall)
                .clickable {
                     OnCloseClick()
                },
            imageVector = Icons.Default.Close,
            contentDescription = "StoreClose"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(
                    id = when(store.maker){
                        "Taito"-> R.drawable.taito_store
                        else->R.drawable.ic_launcher_foreground
                    }
                ),
                contentDescription = store.maker,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .padding(10.dp)

            )

            Spacer(modifier = Modifier.width(spacing.default))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clickable {
                        OnItemClick(store)
                    }
            ) {
                Text(
                    text = store.name,
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                Text(
                    text = store.address,
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp
                )
            }
        }

    }

}