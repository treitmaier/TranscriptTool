/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.reitmaier.transcripttool.data

import io.reitmaier.transcripttool.core.data.DefaultTranscriptRepository
import io.reitmaier.transcripttool.core.database.Transcript
import io.reitmaier.transcripttool.core.database.TranscriptDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit tests for [DefaultTranscriptRepository].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultTranscriptRepositoryTest {

  @Test
  fun transcripts_newItemSaved_itemIsReturned() = runTest {
    val repository = DefaultTranscriptRepository(FakeTranscriptDao())

    repository.add("Repository")

    assertEquals(repository.transcripts.first().size, 1)
  }
}

private class FakeTranscriptDao : TranscriptDao {

  private val data = mutableListOf<Transcript>()

  override fun getTranscripts(): Flow<List<Transcript>> = flow {
    emit(data)
  }

  override suspend fun insertTranscript(item: Transcript) {
    data.add(0, item)
  }
}
