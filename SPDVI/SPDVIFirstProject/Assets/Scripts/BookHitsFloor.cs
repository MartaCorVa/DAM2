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
            //float xOffset = Random.Range(-1, 1);
            //book.transform.Translate(new Vector3(xOffset, 0, 0));
            //float yRotOffset = Random.Range(-90.0f, 90.0f);
        }

    }
}
