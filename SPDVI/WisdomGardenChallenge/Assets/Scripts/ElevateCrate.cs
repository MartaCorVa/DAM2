using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityStandardAssets.Characters.FirstPerson;

public class ElevateCrate : MonoBehaviour
{
    private bool isUp = false;
    [SerializeField]
    private Canvas menu;
    
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
        menu.enabled = false;
    }

    // Update is called once per frame
    void Update()
    {
        if (isUp)
        {
            if (gameObject.transform.position.y != 5.0f)
            {
                gameObject.transform.Translate(Vector3.up * Time.deltaTime);
            } 
        }
        if (gameObject.transform.position.y > 5.0f)
        {
            Time.timeScale = 0;
            if (Input.GetKeyDown(KeyCode.K))
            {
                menu.enabled = true;
                GameObject.Find("FPSController").GetComponent<FirstPersonController>().enabled = false;
                // Enable Cursor
                Cursor.lockState = CursorLockMode.None;
                Cursor.visible = true;
            }
        }
    }
}
