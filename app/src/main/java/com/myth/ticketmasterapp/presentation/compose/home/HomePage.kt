package com.myth.ticketmasterapp.presentation.compose.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homePage() {
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
                    Text(
                        text = "Sample Popular Event",
                        modifier =
                            Modifier
                                .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
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
                    Text(
                        text = "Sample Popular Event",
                        modifier =
                            Modifier
                                .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
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
                    Text(
                        text = "Sample Popular Event",
                        modifier =
                            Modifier
                                .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
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
                    Text(
                        text = "Sample Popular Event",
                        modifier =
                            Modifier
                                .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
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
                    Text(
                        text = "Sample Favorite Event",
                        modifier =
                            Modifier
                                .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
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
                    Text(
                        text = "Sample Favorite Event",
                        modifier =
                            Modifier
                                .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
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
                    Text(
                        text = "Sample Favorite Event",
                        modifier =
                            Modifier
                                .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
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
    homePage()
}
