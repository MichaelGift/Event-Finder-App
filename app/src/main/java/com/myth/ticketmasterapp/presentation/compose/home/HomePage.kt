package com.myth.ticketmasterapp.presentation.compose.home

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    var searchQuery by remember { mutableStateOf("") }
    var searchState by remember { mutableStateOf(false) }

    // Categories
    var music by remember { mutableStateOf(false) }
    var sports by remember { mutableStateOf(false) }
    var art by remember { mutableStateOf(false) }
    var theater by remember { mutableStateOf(false) }
    var concert by remember { mutableStateOf(false) }
    var festival by remember { mutableStateOf(false) }
    var exhibit by remember { mutableStateOf(false) }
    val categoriesScroll = rememberScrollState()

    // popular
    val popularScroll = rememberScrollState()

    // Favorites
    val favoritesScroll = rememberScrollState()
// Top App bar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Event Finder") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding),
        ) {
            // Search Bar
            SearchBar(
                modifier =
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = {},
                active = searchState,
                onActiveChange = { searchState = it },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                placeholder = { Text("Search events") },
            ) {
            }
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Categories",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
            // Category Chips
            Row(
                modifier =
                Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .horizontalScroll(categoriesScroll),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                FilterChip(
                    selected = music,
                    onClick = { music = !music },
                    label = { Text("Music") },
                    leadingIcon =
                    if (music) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    },
                )
                FilterChip(
                    selected = sports,
                    onClick = { sports = !sports },
                    label = { Text("Sports") },
                    leadingIcon =
                    if (sports) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    },
                )
                FilterChip(
                    selected = art,
                    onClick = { art = !art },
                    label = { Text("Art") },
                    leadingIcon =
                    if (art) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    },
                )
                FilterChip(
                    selected = theater,
                    onClick = { theater = !theater },
                    label = { Text("Theater") },
                    leadingIcon =
                    if (theater) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    },
                )
                FilterChip(
                    selected = concert,
                    onClick = { concert = !concert },
                    label = { Text("Concert") },
                    leadingIcon =
                    if (concert) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    },
                )
                FilterChip(
                    selected = festival,
                    onClick = { festival = !festival },
                    label = { Text("Festival") },
                    leadingIcon =
                    if (festival) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    },
                )
                FilterChip(
                    selected = exhibit,
                    onClick = { exhibit = !exhibit },
                    label = { Text("Exhibit") },
                    leadingIcon =
                    if (exhibit) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    },
                )
            }

            // Popular section
            Spacer(modifier = Modifier.padding(2.dp))
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Popular",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                IconButton(onClick = { }) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Right Arrow",
                    )
                }
            }
            Spacer(modifier = Modifier.padding(2.dp))
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .horizontalScroll(popularScroll),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ElevatedCard(
                    elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                    ),
                    modifier =
                    Modifier
                        .size(width = 180.dp, height = 240.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        SubcomposeAsyncImage(
                            model = "https://ew.com/thmb/xc2Q_hUwLK6BQs5HfvlMAoTgBTY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/taylor-swift-031823-01-2000-5efc5ff678ec42a8abdb1b7b4fd35486.jpg",
                            contentDescription = "Taylor Swift",
                            loading = { CircularProgressIndicator() },
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(Color.Transparent, Color.Black),
                                        0f, 600f
                                    )
                                ),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Tyler Swift Eras Tour",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
                ElevatedCard(
                    elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                    ),
                    modifier =
                    Modifier
                        .size(width = 180.dp, height = 240.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        SubcomposeAsyncImage(
                            model = "https://metalinsider.net/site/wp-content/uploads/2022/04/Dragonforce_2022_19.jpg",
                            contentDescription = "Dragon Force",
                            loading = { CircularProgressIndicator() },
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(Color.Transparent, Color.Black),
                                        0f, 600f
                                    )
                                ),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Visions of Atlantis",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
                ElevatedCard(
                    elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                    ),
                    modifier =
                    Modifier
                        .size(width = 180.dp, height = 240.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        SubcomposeAsyncImage(
                            model = "https://artistsden.wpenginepowered.com/wp-content/uploads/2019/09/ImagineDragons_317.jpg",
                            contentDescription = "Imagine Dragons",
                            loading = { CircularProgressIndicator() },
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(Color.Transparent, Color.Black),
                                        0f, 600f
                                    )
                                ),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Radio Active",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
                ElevatedCard(
                    elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                    ),
                    modifier =
                    Modifier
                        .size(width = 180.dp, height = 240.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        SubcomposeAsyncImage(
                            model = "https://www.gqmiddleeast.com/cloud/2023/11/06/GQ-Features-Image-2023-11-06T112132.867.png",
                            contentDescription = "Chris Brown",
                            loading = { CircularProgressIndicator() },
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(Color.Transparent, Color.Black),
                                        0f, 600f
                                    )
                                ),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "The 11:11 Tour",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }

            // Favorites section
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Favorites",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                IconButton(onClick = { }) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Right Arrow",
                    )
                }
            }
            Spacer(modifier = Modifier.padding(2.dp))
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .horizontalScroll(favoritesScroll),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ElevatedCard(
                    elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                    ),
                    modifier =
                    Modifier
                        .size(width = 180.dp, height = 240.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        SubcomposeAsyncImage(
                            model = "https://www.gqmiddleeast.com/cloud/2023/11/06/GQ-Features-Image-2023-11-06T112132.867.png",
                            contentDescription = "Chris Brown",
                            loading = { CircularProgressIndicator() },
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(Color.Transparent, Color.Black),
                                        0f, 600f
                                    )
                                ),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "The 11:11 Tour",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
                ElevatedCard(
                    elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                    ),
                    modifier =
                    Modifier
                        .size(width = 180.dp, height = 240.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        SubcomposeAsyncImage(
                            model = "https://www.gqmiddleeast.com/cloud/2023/11/06/GQ-Features-Image-2023-11-06T112132.867.png",
                            contentDescription = "Chris Brown",
                            loading = { CircularProgressIndicator() },
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(Color.Transparent, Color.Black),
                                        0f, 600f
                                    )
                                ),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "The 11:11 Tour",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
                ElevatedCard(
                    elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 6.dp,
                    ),
                    modifier =
                    Modifier
                        .size(width = 180.dp, height = 240.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        SubcomposeAsyncImage(
                            model = "https://www.gqmiddleeast.com/cloud/2023/11/06/GQ-Features-Image-2023-11-06T112132.867.png",
                            contentDescription = "Chris Brown",
                            loading = { CircularProgressIndicator() },
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        listOf(Color.Transparent, Color.Black),
                                        0f, 600f
                                    )
                                ),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "The 11:11 Tour",
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
            // Popular event section
            // Event's near you
        }
    }
}

@Preview
@Composable
fun homePagePreview() {
    HomePage()
}
