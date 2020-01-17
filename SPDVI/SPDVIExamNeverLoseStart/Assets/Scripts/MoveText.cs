using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class MoveText : MonoBehaviour
{
    [SerializeField]
    private Text text;
    bool isInside = false;

    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.name == "Player")
        {
            isInside = true;
        } 
    }

    private void OnTriggerExit(Collider other)
    {
        if (other.gameObject.name == "Player")
        {
            isInside = false;
        }
    }

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (isInside)
        {
            text.gameObject.transform.Translate(Vector3.up * Time.deltaTime);
            
        }
        {
            text.gameObject.transform.Translate(Vector3.zero);
        }
    }
}
