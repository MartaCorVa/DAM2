using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BookCreator : MonoBehaviour
{
    [SerializeField]
    private GameObject book;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            GameObject bulletBook = Instantiate(book, transform.position, Quaternion.identity) as GameObject;
            bulletBook.GetComponent<Rigidbody>().AddForce(transform.forward * 500);
            bulletBook.GetComponent<Rigidbody>().AddTorque(Random.Range(60,90), Random.Range(30, 60), Random.Range(90, 120));
        }
    }
}
