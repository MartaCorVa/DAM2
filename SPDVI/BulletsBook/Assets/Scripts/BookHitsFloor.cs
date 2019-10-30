using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BookHitsFloor : MonoBehaviour
{
    public GameObject bookPrefabReference;
    private void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.name == "Book(Clone)" || collision.gameObject.name == "book_0001a")
        {
            GameObject book = Instantiate(bookPrefabReference);
        }
    }
}
