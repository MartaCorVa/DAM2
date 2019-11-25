using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.AI;
using TMPro;

public class TryToOpenCrate : MonoBehaviour
{

    [SerializeField]
    private TextMeshPro label;
    [SerializeField]
    private Image background;
    [SerializeField]
    private TMP_InputField input;
    [SerializeField]
    private TextMeshProUGUI button;
    [SerializeField]
    private BulletCreator bullet;

    private void OnTriggerEnter(Collider other)
    {
        // Stop time
        Time.timeScale = 0;

        // Assign keyboard focus to InputField
        input.ActivateInputField();

        //Enable Cursor
        Cursor.lockState = CursorLockMode.None;
        Cursor.visible = true;
    }

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
