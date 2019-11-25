using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ElevateCrate : MonoBehaviour
{
    private bool isUp = false;
    
    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.name == "FPSController")
        {
            isUp = true; 
        } else
        {
            isUp = false;
        }
    }
    
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (isUp)
        {
            if (gameObject.transform.position.y != 5.63f)
            {
                gameObject.transform.Translate(Vector3.up * Time.deltaTime);
            } 
        }        
    }
}
