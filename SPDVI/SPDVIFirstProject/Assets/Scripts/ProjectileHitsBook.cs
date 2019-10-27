using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ProjectileHitsBook : MonoBehaviour
{
    public GameObject bookPrefabReference;
    private void OnCollisionEnter(Collision collision)
    {
        Debug.Log(collision.gameObject.name);
        if (collision.gameObject.name == "Book(Clone)" || collision.gameObject.name == "book_0001a")
        {
            Destroy(collision.gameObject, 3.0f);
        }
        
    }
}
