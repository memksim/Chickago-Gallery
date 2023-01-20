package com.memksim.chickagogallery.data.repository

import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.memksim.chickagogallery.data.firestore.Constants
import com.memksim.chickagogallery.data.firestore.Constants.DOCUMENT_NAME
import com.memksim.chickagogallery.data.local.entity.Bookmark
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    suspend fun getBookmarksList(
        failureListener: ((e: Exception) -> Unit)?
    ): QuerySnapshot{
        return firestore.collection(DOCUMENT_NAME)
            .get()
            .addOnFailureListener {
                if (failureListener != null) {
                    failureListener(it)
                }
            }.await()
    }

    suspend fun addBookmark(
        bookmark: Bookmark,
        failureListener: ((e: Exception) -> Unit)?
    ){
        firestore.collection(DOCUMENT_NAME)
            .add(bookmark)
            .addOnFailureListener {
                if(failureListener != null){
                    failureListener(it)
                }
            }
    }

    suspend fun removeBookmark(
        bookmark: Bookmark,
        failureListener: ((e: Exception) -> Unit)?
    ){
        firestore.collection(DOCUMENT_NAME)
            .whereEqualTo(Constants.ARTWORK_ID, bookmark.bookmarkId)
            .get()
            .addOnSuccessListener {
                firestore.collection(DOCUMENT_NAME)
                    .document(it.documents[0].id)
                    .delete()
                    .addOnSuccessListener {

                    }
                    .addOnFailureListener { e ->
                        if(failureListener != null){
                            failureListener(e)
                        }
                    }
            }
            .addOnFailureListener {
                if(failureListener != null){
                    failureListener(it)
                }
            }
    }

}