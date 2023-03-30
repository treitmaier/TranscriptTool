package io.reitmaier.transcripttool.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetListItem(icon: ImageVector, title: String, contentDescription: String, onItemClick: (String) -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clickable(onClick = { onItemClick(title) })
      .height(55.dp)
      .background(color = MaterialTheme.colorScheme.surface)
      .padding(start = 16.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Icon(imageVector = icon, contentDescription = contentDescription, tint = MaterialTheme.colorScheme.onSurface)
    Spacer(modifier = Modifier.width(20.dp))
    Text(text = title, color = MaterialTheme.colorScheme.onSurface)
  }
}
